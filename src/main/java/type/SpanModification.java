

/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** An annotation which modifies a span (e.g. a tokenization).
 * Updated by JCasGen Mon Oct 05 10:08:06 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class SpanModification extends Span {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SpanModification.class);
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
  protected SpanModification() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public SpanModification(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public SpanModification(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public SpanModification(JCas jcas, int begin, int end) {
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
  //* Feature: span

  /** getter for span - gets The original span annotation for this downstream annotation.
   * @generated
   * @return value of the feature 
   */
  public Span getSpan() {
    if (SpanModification_Type.featOkTst && ((SpanModification_Type)jcasType).casFeat_span == null)
      jcasType.jcas.throwFeatMissing("span", "type.SpanModification");
    return (Span)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SpanModification_Type)jcasType).casFeatCode_span)));}
    
  /** setter for span - sets The original span annotation for this downstream annotation. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSpan(Span v) {
    if (SpanModification_Type.featOkTst && ((SpanModification_Type)jcasType).casFeat_span == null)
      jcasType.jcas.throwFeatMissing("span", "type.SpanModification");
    jcasType.ll_cas.ll_setRefValue(addr, ((SpanModification_Type)jcasType).casFeatCode_span, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: passage

  /** getter for passage - gets Hack to get the span to cast to a passage in the case that it's supposed to.
   * @generated
   * @return value of the feature 
   */
  public Passage getPassage() {
    if (SpanModification_Type.featOkTst && ((SpanModification_Type)jcasType).casFeat_passage == null)
      jcasType.jcas.throwFeatMissing("passage", "type.SpanModification");
    return (Passage)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SpanModification_Type)jcasType).casFeatCode_passage)));}
    
  /** setter for passage - sets Hack to get the span to cast to a passage in the case that it's supposed to. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassage(Passage v) {
    if (SpanModification_Type.featOkTst && ((SpanModification_Type)jcasType).casFeat_passage == null)
      jcasType.jcas.throwFeatMissing("passage", "type.SpanModification");
    jcasType.ll_cas.ll_setRefValue(addr, ((SpanModification_Type)jcasType).casFeatCode_passage, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    