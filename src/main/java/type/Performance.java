

/* First created by JCasGen Mon Sep 28 00:00:30 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Mon Sep 28 02:13:23 EDT 2015
 * XML source: /Users/zal/CMU/TA/f15-11-791/template-projects/pi5/pi5-andrewid/src/main/resources/descriptors/questionPassageReaderDescriptor.xml
 * @generated */
public class Performance extends TOP {
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

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: f1

  /** getter for f1 - gets This is the F1 measure of the question
   * @generated
   * @return value of the feature 
   */
  public double getF1() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_f1 == null)
      jcasType.jcas.throwFeatMissing("f1", "type.Performance");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_f1);}
    
  /** setter for f1 - sets This is the F1 measure of the question 
   * @generated
   * @param v value to set into the feature 
   */
  public void setF1(double v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_f1 == null)
      jcasType.jcas.throwFeatMissing("f1", "type.Performance");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_f1, v);}    
   
    
  //*--------------*
  //* Feature: pAt1

  /** getter for pAt1 - gets This is the Precision@1 for the question
   * @generated
   * @return value of the feature 
   */
  public double getPAt1() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt1 == null)
      jcasType.jcas.throwFeatMissing("pAt1", "type.Performance");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt1);}
    
  /** setter for pAt1 - sets This is the Precision@1 for the question 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPAt1(double v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt1 == null)
      jcasType.jcas.throwFeatMissing("pAt1", "type.Performance");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt1, v);}    
   
    
  //*--------------*
  //* Feature: pAt5

  /** getter for pAt5 - gets This is the Precision@5 of the question.
   * @generated
   * @return value of the feature 
   */
  public double getPAt5() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt5 == null)
      jcasType.jcas.throwFeatMissing("pAt5", "type.Performance");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt5);}
    
  /** setter for pAt5 - sets This is the Precision@5 of the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPAt5(double v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_pAt5 == null)
      jcasType.jcas.throwFeatMissing("pAt5", "type.Performance");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_pAt5, v);}    
   
    
  //*--------------*
  //* Feature: mmr

  /** getter for mmr - gets This is the Maximum Marginal Relevance measurment of the question.
   * @generated
   * @return value of the feature 
   */
  public double getMmr() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_mmr == null)
      jcasType.jcas.throwFeatMissing("mmr", "type.Performance");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_mmr);}
    
  /** setter for mmr - sets This is the Maximum Marginal Relevance measurment of the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMmr(double v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_mmr == null)
      jcasType.jcas.throwFeatMissing("mmr", "type.Performance");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_mmr, v);}    
   
    
  //*--------------*
  //* Feature: map

  /** getter for map - gets This is the Mean Average Precision measurement of the question.
   * @generated
   * @return value of the feature 
   */
  public double getMap() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_map == null)
      jcasType.jcas.throwFeatMissing("map", "type.Performance");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_map);}
    
  /** setter for map - sets This is the Mean Average Precision measurement of the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMap(double v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_map == null)
      jcasType.jcas.throwFeatMissing("map", "type.Performance");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_map, v);}    
  }

    