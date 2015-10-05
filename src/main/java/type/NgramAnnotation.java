

/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** Annotates ngrams for the relevant parts of a test element.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class NgramAnnotation extends SpanModification {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NgramAnnotation.class);
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
  protected NgramAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NgramAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NgramAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NgramAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: questionNgrams

  /** getter for questionNgrams - gets The set of ngrams annotated for the question associated with this Test Element.
   * @generated
   * @return value of the feature 
   */
  public NgramSet getQuestionNgrams() {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_questionNgrams == null)
      jcasType.jcas.throwFeatMissing("questionNgrams", "type.NgramAnnotation");
    return (NgramSet)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_questionNgrams)));}
    
  /** setter for questionNgrams - sets The set of ngrams annotated for the question associated with this Test Element. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestionNgrams(NgramSet v) {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_questionNgrams == null)
      jcasType.jcas.throwFeatMissing("questionNgrams", "type.NgramAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_questionNgrams, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: passageNgrams

  /** getter for passageNgrams - gets List of sets of ngrams for each of the respective passages associated with this Test Element.
   * @generated
   * @return value of the feature 
   */
  public FSList getPassageNgrams() {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_passageNgrams == null)
      jcasType.jcas.throwFeatMissing("passageNgrams", "type.NgramAnnotation");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_passageNgrams)));}
    
  /** setter for passageNgrams - sets List of sets of ngrams for each of the respective passages associated with this Test Element. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassageNgrams(FSList v) {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_passageNgrams == null)
      jcasType.jcas.throwFeatMissing("passageNgrams", "type.NgramAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_passageNgrams, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    