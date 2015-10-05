

/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** The finished output for the annotated test element.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class OutputAnnotation extends SpanModification {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OutputAnnotation.class);
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
  protected OutputAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public OutputAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public OutputAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public OutputAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: output

  /** getter for output - gets The output for the annotated test element.
   * @generated
   * @return value of the feature 
   */
  public String getOutput() {
    if (OutputAnnotation_Type.featOkTst && ((OutputAnnotation_Type)jcasType).casFeat_output == null)
      jcasType.jcas.throwFeatMissing("output", "type.OutputAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OutputAnnotation_Type)jcasType).casFeatCode_output);}
    
  /** setter for output - sets The output for the annotated test element. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOutput(String v) {
    if (OutputAnnotation_Type.featOkTst && ((OutputAnnotation_Type)jcasType).casFeat_output == null)
      jcasType.jcas.throwFeatMissing("output", "type.OutputAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((OutputAnnotation_Type)jcasType).casFeatCode_output, v);}    
  }

    