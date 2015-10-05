

/* First created by JCasGen Mon Oct 05 10:45:47 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Annotates performance of the system on a single test element.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class Performance extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Performance.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Performance() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Performance(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Performance(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Performance(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: testElement

  /** getter for testElement - gets The test element annotated with this performance.
   * @generated
   * @return value of the feature 
   */
  public TestElementAnnotation getTestElement() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_testElement == null)
      jcasType.jcas.throwFeatMissing("testElement", "type.Performance");
    return (TestElementAnnotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Performance_Type)jcasType).casFeatCode_testElement)));}
    
  /** setter for testElement - sets The test element annotated with this performance. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTestElement(TestElementAnnotation v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_testElement == null)
      jcasType.jcas.throwFeatMissing("testElement", "type.Performance");
    jcasType.ll_cas.ll_setRefValue(addr, ((Performance_Type)jcasType).casFeatCode_testElement, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: pAt1

  /** getter for pAt1 - gets Precision@1 for this Test Element.
   * @generated
   * @return value of the feature 
   */
  public float getPAt1() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt1 == null)
      jcasType.jcas.throwFeatMissing("pAt1", "type.Performance");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt1);}
    
  /** setter for pAt1 - sets Precision@1 for this Test Element. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPAt1(float v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt1 == null)
      jcasType.jcas.throwFeatMissing("pAt1", "type.Performance");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt1, v);}    
   
    
  //*--------------*
  //* Feature: pAt5

  /** getter for pAt5 - gets Precision@5 for this Test Element.
   * @generated
   * @return value of the feature 
   */
  public float getPAt5() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt5 == null)
      jcasType.jcas.throwFeatMissing("pAt5", "type.Performance");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt5);}
    
  /** setter for pAt5 - sets Precision@5 for this Test Element. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPAt5(float v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt5 == null)
      jcasType.jcas.throwFeatMissing("pAt5", "type.Performance");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt5, v);}    
   
    
  //*--------------*
  //* Feature: rr

  /** getter for rr - gets Reciprocal rank for this Test Element
   * @generated
   * @return value of the feature 
   */
  public float getRr() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_rr == null)
      jcasType.jcas.throwFeatMissing("rr", "type.Performance");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_rr);}
    
  /** setter for rr - sets Reciprocal rank for this Test Element 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRr(float v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_rr == null)
      jcasType.jcas.throwFeatMissing("rr", "type.Performance");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_rr, v);}    
   
    
  //*--------------*
  //* Feature: ap

  /** getter for ap - gets AP for this test element.
   * @generated
   * @return value of the feature 
   */
  public float getAp() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_ap == null)
      jcasType.jcas.throwFeatMissing("ap", "type.Performance");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_ap);}
    
  /** setter for ap - sets AP for this test element. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAp(float v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_ap == null)
      jcasType.jcas.throwFeatMissing("ap", "type.Performance");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Performance_Type)jcasType).casFeatCode_ap, v);}    
  }

    