

/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Component Annotation with a text field to identify the relevant text of the annotated span.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class Span extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Span.class);
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
  protected Span() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Span(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Span(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Span(JCas jcas, int begin, int end) {
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
  //* Feature: text

  /** getter for text - gets The relevant text of the annotated Span
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (Span_Type.featOkTst && ((Span_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "type.Span");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Span_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The relevant text of the annotated Span 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (Span_Type.featOkTst && ((Span_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "type.Span");
    jcasType.ll_cas.ll_setStringValue(addr, ((Span_Type)jcasType).casFeatCode_text, v);}    
  }

    