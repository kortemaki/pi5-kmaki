
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

/** Stores the information of the passage.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * @generated */
public class Passage_Type extends Span_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Passage_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Passage_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Passage(addr, Passage_Type.this);
  			   Passage_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Passage(addr, Passage_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Passage.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.Passage");
 
  /** @generated */
  final Feature casFeat_label;
  /** @generated */
  final int     casFeatCode_label;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getLabel(int addr) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "type.Passage");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_label);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLabel(int addr, boolean v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "type.Passage");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_label, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sourceDocId;
  /** @generated */
  final int     casFeatCode_sourceDocId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSourceDocId(int addr) {
        if (featOkTst && casFeat_sourceDocId == null)
      jcas.throwFeatMissing("sourceDocId", "type.Passage");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sourceDocId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSourceDocId(int addr, String v) {
        if (featOkTst && casFeat_sourceDocId == null)
      jcas.throwFeatMissing("sourceDocId", "type.Passage");
    ll_cas.ll_setStringValue(addr, casFeatCode_sourceDocId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_passage;
  /** @generated */
  final int     casFeatCode_passage;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPassage(int addr) {
        if (featOkTst && casFeat_passage == null)
      jcas.throwFeatMissing("passage", "type.Passage");
    return ll_cas.ll_getRefValue(addr, casFeatCode_passage);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPassage(int addr, int v) {
        if (featOkTst && casFeat_passage == null)
      jcas.throwFeatMissing("passage", "type.Passage");
    ll_cas.ll_setRefValue(addr, casFeatCode_passage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_question;
  /** @generated */
  final int     casFeatCode_question;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestion(int addr) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "type.Passage");
    return ll_cas.ll_getRefValue(addr, casFeatCode_question);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestion(int addr, int v) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "type.Passage");
    ll_cas.ll_setRefValue(addr, casFeatCode_question, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Passage_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.Boolean", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

 
    casFeat_sourceDocId = jcas.getRequiredFeatureDE(casType, "sourceDocId", "uima.cas.String", featOkTst);
    casFeatCode_sourceDocId  = (null == casFeat_sourceDocId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceDocId).getCode();

 
    casFeat_passage = jcas.getRequiredFeatureDE(casType, "passage", "type.Span", featOkTst);
    casFeatCode_passage  = (null == casFeat_passage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_passage).getCode();

 
    casFeat_question = jcas.getRequiredFeatureDE(casType, "question", "type.Question", featOkTst);
    casFeatCode_question  = (null == casFeat_question) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_question).getCode();

  }
}



    