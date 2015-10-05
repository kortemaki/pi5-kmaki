
/* First created by JCasGen Mon Oct 05 10:45:47 EDT 2015 */
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

/** Annotates performance of the system on a single test element.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * @generated */
public class Performance_Type extends ComponentAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Performance_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Performance_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Performance(addr, Performance_Type.this);
  			   Performance_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Performance(addr, Performance_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Performance.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.Performance");
 
  /** @generated */
  final Feature casFeat_testElement;
  /** @generated */
  final int     casFeatCode_testElement;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTestElement(int addr) {
        if (featOkTst && casFeat_testElement == null)
      jcas.throwFeatMissing("testElement", "type.Performance");
    return ll_cas.ll_getRefValue(addr, casFeatCode_testElement);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTestElement(int addr, int v) {
        if (featOkTst && casFeat_testElement == null)
      jcas.throwFeatMissing("testElement", "type.Performance");
    ll_cas.ll_setRefValue(addr, casFeatCode_testElement, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pAt1;
  /** @generated */
  final int     casFeatCode_pAt1;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getPAt1(int addr) {
        if (featOkTst && casFeat_pAt1 == null)
      jcas.throwFeatMissing("pAt1", "type.Performance");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_pAt1);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPAt1(int addr, float v) {
        if (featOkTst && casFeat_pAt1 == null)
      jcas.throwFeatMissing("pAt1", "type.Performance");
    ll_cas.ll_setFloatValue(addr, casFeatCode_pAt1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pAt5;
  /** @generated */
  final int     casFeatCode_pAt5;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getPAt5(int addr) {
        if (featOkTst && casFeat_pAt5 == null)
      jcas.throwFeatMissing("pAt5", "type.Performance");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_pAt5);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPAt5(int addr, float v) {
        if (featOkTst && casFeat_pAt5 == null)
      jcas.throwFeatMissing("pAt5", "type.Performance");
    ll_cas.ll_setFloatValue(addr, casFeatCode_pAt5, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rr;
  /** @generated */
  final int     casFeatCode_rr;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getRr(int addr) {
        if (featOkTst && casFeat_rr == null)
      jcas.throwFeatMissing("rr", "type.Performance");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_rr);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRr(int addr, float v) {
        if (featOkTst && casFeat_rr == null)
      jcas.throwFeatMissing("rr", "type.Performance");
    ll_cas.ll_setFloatValue(addr, casFeatCode_rr, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ap;
  /** @generated */
  final int     casFeatCode_ap;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getAp(int addr) {
        if (featOkTst && casFeat_ap == null)
      jcas.throwFeatMissing("ap", "type.Performance");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_ap);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAp(int addr, float v) {
        if (featOkTst && casFeat_ap == null)
      jcas.throwFeatMissing("ap", "type.Performance");
    ll_cas.ll_setFloatValue(addr, casFeatCode_ap, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Performance_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_testElement = jcas.getRequiredFeatureDE(casType, "testElement", "type.TestElementAnnotation", featOkTst);
    casFeatCode_testElement  = (null == casFeat_testElement) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_testElement).getCode();

 
    casFeat_pAt1 = jcas.getRequiredFeatureDE(casType, "pAt1", "uima.cas.Float", featOkTst);
    casFeatCode_pAt1  = (null == casFeat_pAt1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pAt1).getCode();

 
    casFeat_pAt5 = jcas.getRequiredFeatureDE(casType, "pAt5", "uima.cas.Float", featOkTst);
    casFeatCode_pAt5  = (null == casFeat_pAt5) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pAt5).getCode();

 
    casFeat_rr = jcas.getRequiredFeatureDE(casType, "rr", "uima.cas.Float", featOkTst);
    casFeatCode_rr  = (null == casFeat_rr) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rr).getCode();

 
    casFeat_ap = jcas.getRequiredFeatureDE(casType, "ap", "uima.cas.Float", featOkTst);
    casFeatCode_ap  = (null == casFeat_ap) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ap).getCode();

  }
}



    