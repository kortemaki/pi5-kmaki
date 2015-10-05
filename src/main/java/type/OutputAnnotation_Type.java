
/* First created by JCasGen Mon Oct 05 10:08:06 EDT 2015 */
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

/** The finished output for the annotated test element.
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * @generated */
public class OutputAnnotation_Type extends SpanModification_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (OutputAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = OutputAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new OutputAnnotation(addr, OutputAnnotation_Type.this);
  			   OutputAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new OutputAnnotation(addr, OutputAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = OutputAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.OutputAnnotation");
 
  /** @generated */
  final Feature casFeat_output;
  /** @generated */
  final int     casFeatCode_output;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getOutput(int addr) {
        if (featOkTst && casFeat_output == null)
      jcas.throwFeatMissing("output", "type.OutputAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_output);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOutput(int addr, String v) {
        if (featOkTst && casFeat_output == null)
      jcas.throwFeatMissing("output", "type.OutputAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_output, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public OutputAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_output = jcas.getRequiredFeatureDE(casType, "output", "uima.cas.String", featOkTst);
    casFeatCode_output  = (null == casFeat_output) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_output).getCode();

  }
}



    