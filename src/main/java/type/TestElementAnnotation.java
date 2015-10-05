

/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Annotation which builds on a test element.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class TestElementAnnotation extends Span {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TestElementAnnotation.class);
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
  protected TestElementAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TestElementAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TestElementAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TestElementAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: question

  /** getter for question - gets The question associated with this annotation.
   * @generated
   * @return value of the feature 
   */
  public Question getQuestion() {
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "type.TestElementAnnotation");
    return (Question)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_question)));}
    
  /** setter for question - sets The question associated with this annotation. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestion(Question v) {
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "type.TestElementAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_question, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    