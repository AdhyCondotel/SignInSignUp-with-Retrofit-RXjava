package com.ammase.latihanprodukdetail.model.listuser;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataItem{

	@SerializedName("name")
	private String name;

	@SerializedName("registered")
	private String registered;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRegistered(String registered){
		this.registered = registered;
	}

	public String getRegistered(){
		return registered;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"name = '" + name + '\'' + 
			",registered = '" + registered + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}