
/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** Annotates a test element with tokenizations for the question and each of its passages.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * @generated */
public class TokenAnnotation_Type extends SpanModification_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TokenAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TokenAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TokenAnnotation(addr, TokenAnnotation_Type.this);
  			   TokenAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TokenAnnotation(addr, TokenAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TokenAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.TokenAnnotation");
 
  /** @generated */
  final Feature casFeat_questionTokens;
  /** @generated */
  final int     casFeatCode_questionTokens;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestionTokens(int addr) {
        if (featOkTst && casFeat_questionTokens == null)
      jcas.throwFeatMissing("questionTokens", "type.TokenAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_questionTokens);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestionTokens(int addr, int v) {
        if (featOkTst && casFeat_questionTokens == null)
      jcas.throwFeatMissing("questionTokens", "type.TokenAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_questionTokens, v);}
    
  
 
  /** @generated */
  final Feature casFeat_passageTokens;
  /** @generated */
  final int     casFeatCode_passageTokens;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPassageTokens(int addr) {
        if (featOkTst && casFeat_passageTokens == null)
      jcas.throwFeatMissing("passageTokens", "type.TokenAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_passageTokens);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPassageTokens(int addr, int v) {
        if (featOkTst && casFeat_passageTokens == null)
      jcas.throwFeatMissing("passageTokens", "type.TokenAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_passageTokens, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TokenAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_questionTokens = jcas.getRequiredFeatureDE(casType, "questionTokens", "type.TokenizedSpan", featOkTst);
    casFeatCode_questionTokens  = (null == casFeat_questionTokens) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionTokens).getCode();

 
    casFeat_passageTokens = jcas.getRequiredFeatureDE(casType, "passageTokens", "uima.cas.FSList", featOkTst);
    casFeatCode_passageTokens  = (null == casFeat_passageTokens) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_passageTokens).getCode();

  }
}



    