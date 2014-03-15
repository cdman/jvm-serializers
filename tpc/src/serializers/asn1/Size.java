package serializers.asn1;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;
//import com.chaosinmotion.asn1.Tag;


public class Size extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	* See 'TestProject.java' in the project to examine encoding/decoding examples
	*/
	
	public static final int  small_ = 0;

	public void setTo_small_0() {
		setValue(small_);
	}

	public static final int  large_ = 1;

	public void setTo_large_1() {
		setValue(large_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	Size()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	Size(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Size(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Size(String name, long value)
	{
		super(name, value);
	}
}
