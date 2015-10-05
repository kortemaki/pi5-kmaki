
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

/** An annotation which modifies a span (e.g. a tokenization).
 * Updated by JCasGen Mon Oct 05 15:32:22 EDT 2015
 * @generated */
public class SpanModification_Type extends Span_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SpanModification_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SpanModification_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SpanModification(addr, SpanModification_Type.this);
  			   SpanModification_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SpanModification(addr, SpanModification_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SpanModification.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.SpanModification");
 
  /** @generated */
  final Feature casFeat_orig;
  /** @generated */
  final int     casFeatCode_orig;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getOrig(int addr) {
        if (featOkTst && casFeat_orig == null)
      jcas.throwFeatMissing("orig", "type.SpanModification");
    return ll_cas.ll_getRefValue(addr, casFeatCode_orig);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOrig(int addr, int v) {
        if (featOkTst && casFeat_orig == null)
      jcas.throwFeatMissing("orig", "type.SpanModification");
    ll_cas.ll_setRefValue(addr, casFeatCode_orig, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public SpanModification_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_orig = jcas.getRequiredFeatureDE(casType, "orig", "type.Span", featOkTst);
    casFeatCode_orig  = (null == casFeat_orig) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_orig).getCode();

  }
}



    