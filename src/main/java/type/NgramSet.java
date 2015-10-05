

/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** Holds a set of ngrams annotated within the annotated span.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI5/pi5-kmaki/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class NgramSet extends SpanModification {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NgramSet.class);
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
  protected NgramSet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NgramSet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NgramSet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NgramSet(JCas jcas, int begin, int end) {
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
  //* Feature: ngrams

  /** getter for ngrams - gets Array of ngrams annotated for this Span.
   * @generated
   * @return value of the feature 
   */
  public FSArray getNgrams() {
    if (NgramSet_Type.featOkTst && ((NgramSet_Type)jcasType).casFeat_ngrams == null)
      jcasType.jcas.throwFeatMissing("ngrams", "type.NgramSet");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams)));}
    
  /** setter for ngrams - sets Array of ngrams annotated for this Span. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNgrams(FSArray v) {
    if (NgramSet_Type.featOkTst && ((NgramSet_Type)jcasType).casFeat_ngrams == null)
      jcasType.jcas.throwFeatMissing("ngrams", "type.NgramSet");
    jcasType.ll_cas.ll_setRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for ngrams - gets an indexed value - Array of ngrams annotated for this Span.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Ngram getNgrams(int i) {
    if (NgramSet_Type.featOkTst && ((NgramSet_Type)jcasType).casFeat_ngrams == null)
      jcasType.jcas.throwFeatMissing("ngrams", "type.NgramSet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams), i);
    return (Ngram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams), i)));}

  /** indexed setter for ngrams - sets an indexed value - Array of ngrams annotated for this Span.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setNgrams(int i, Ngram v) { 
    if (NgramSet_Type.featOkTst && ((NgramSet_Type)jcasType).casFeat_ngrams == null)
      jcasType.jcas.throwFeatMissing("ngrams", "type.NgramSet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    