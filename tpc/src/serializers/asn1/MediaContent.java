package serializers.asn1;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class MediaContent extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 * See 'TestProject.java' in the project to examine encoding/decoding examples
	 */
	public Media media = new Media("media");
	public SequenceOf images = new SequenceOf("images", new serializers.asn1.Image());
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	MediaContent()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	MediaContent(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(media);
		super.addElement(images);
	/* end of element setup */
	}


}
