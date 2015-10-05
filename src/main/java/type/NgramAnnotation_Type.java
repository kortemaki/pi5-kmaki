
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

/** Annotates ngrams for the relevant parts of a test element.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * @generated */
public class NgramAnnotation_Type extends SpanModification_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NgramAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NgramAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NgramAnnotation(addr, NgramAnnotation_Type.this);
  			   NgramAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NgramAnnotation(addr, NgramAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NgramAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.NgramAnnotation");
 
  /** @generated */
  final Feature casFeat_questionNgrams;
  /** @generated */
  final int     casFeatCode_questionNgrams;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestionNgrams(int addr) {
        if (featOkTst && casFeat_questionNgrams == null)
      jcas.throwFeatMissing("questionNgrams", "type.NgramAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_questionNgrams);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestionNgrams(int addr, int v) {
        if (featOkTst && casFeat_questionNgrams == null)
      jcas.throwFeatMissing("questionNgrams", "type.NgramAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_questionNgrams, v);}
    
  
 
  /** @generated */
  final Feature casFeat_passageNgrams;
  /** @generated */
  final int     casFeatCode_passageNgrams;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPassageNgrams(int addr) {
        if (featOkTst && casFeat_passageNgrams == null)
      jcas.throwFeatMissing("passageNgrams", "type.NgramAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_passageNgrams);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPassageNgrams(int addr, int v) {
        if (featOkTst && casFeat_passageNgrams == null)
      jcas.throwFeatMissing("passageNgrams", "type.NgramAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_passageNgrams, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NgramAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_questionNgrams = jcas.getRequiredFeatureDE(casType, "questionNgrams", "type.NgramSet", featOkTst);
    casFeatCode_questionNgrams  = (null == casFeat_questionNgrams) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionNgrams).getCode();

 
    casFeat_passageNgrams = jcas.getRequiredFeatureDE(casType, "passageNgrams", "uima.cas.FSList", featOkTst);
    casFeatCode_passageNgrams  = (null == casFeat_passageNgrams) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_passageNgrams).getCode();

  }
}



    