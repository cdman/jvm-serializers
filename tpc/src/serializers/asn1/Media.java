package serializers.asn1;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Media extends Sequence
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
	public OctetString format = new OctetString("format");
	public ASN1Integer duration = new ASN1Integer("duration");
	public ASN1Integer size = new ASN1Integer("size");
	public ASN1Integer bitrate = new ASN1Integer("bitrate");
	public ASN1Boolean hasBitrate = new ASN1Boolean("hasBitrate");
	public Player player = new Player("player");
	public SequenceOf persons = new SequenceOf("persons", new OctetString());
	public OctetString copyright = new OctetString("copyright");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	Media()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	Media(String name)
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
		super.addElement(format);
		super.addElement(duration);
		super.addElement(size);
		super.addElement(bitrate);
		bitrate.setOptional(true);
		super.addElement(hasBitrate);
		super.addElement(player);
		super.addElement(persons);
		super.addElement(copyright);
		copyright.setOptional(true);
	/* end of element setup */
	}


}
