package serializers.asn1;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Image extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 * See 'TestProject.java' in the project to examine encoding/decoding examples
	 */
	public OctetString uri = new OctetString("uri");
	public OctetString title = new OctetString("title");
	public ASN1Integer width = new ASN1Integer("width");
	public ASN1Integer height = new ASN1Integer("height");
	public Size size = new Size("size");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	Image()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	Image(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(uri);
		super.addElement(title);
		title.setOptional(true);
		super.addElement(width);
		super.addElement(height);
		super.addElement(size);
	/* end of element setup */
	}


}
