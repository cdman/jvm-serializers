package serializers.asn1;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;
//import com.chaosinmotion.asn1.Tag;


public class Player extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	* See 'TestProject.java' in the project to examine encoding/decoding examples
	*/
	
	public static final int  java_ = 0;

	public void setTo_java_0() {
		setValue(java_);
	}

	public static final int  flash_ = 1;

	public void setTo_flash_1() {
		setValue(flash_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	Player()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	Player(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Player(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Player(String name, long value)
	{
		super(name, value);
	}
}
