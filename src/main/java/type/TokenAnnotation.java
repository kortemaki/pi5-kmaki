

/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** Annotates a test element with tokenizations for the question and each of its passages.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class TokenAnnotation extends SpanModification {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TokenAnnotation.class);
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
  protected TokenAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TokenAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TokenAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TokenAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: questionTokens

  /** getter for questionTokens - gets The tokenization for the annotated Test Element's question.
   * @generated
   * @return value of the feature 
   */
  public TokenizedSpan getQuestionTokens() {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_questionTokens == null)
      jcasType.jcas.throwFeatMissing("questionTokens", "type.TokenAnnotation");
    return (TokenizedSpan)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_questionTokens)));}
    
  /** setter for questionTokens - sets The tokenization for the annotated Test Element's question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestionTokens(TokenizedSpan v) {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_questionTokens == null)
      jcasType.jcas.throwFeatMissing("questionTokens", "type.TokenAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_questionTokens, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: passageTokens

  /** getter for passageTokens - gets List of tokenizations for the respective passages associated with the annotated Test Element.
   * @generated
   * @return value of the feature 
   */
  public FSList getPassageTokens() {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_passageTokens == null)
      jcasType.jcas.throwFeatMissing("passageTokens", "type.TokenAnnotation");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_passageTokens)));}
    
  /** setter for passageTokens - sets List of tokenizations for the respective passages associated with the annotated Test Element. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassageTokens(FSList v) {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_passageTokens == null)
      jcasType.jcas.throwFeatMissing("passageTokens", "type.TokenAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_passageTokens, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    