package com.m0pt0pmatt.LandPurchasing;

/**
 * An enumeration of all valid LandPurchasing commands.
 * Placing commands in an enumeration makes it easy to change their values.
 * @author Matthew
 *
 */
public enum LandCommand {
	LANDMENU("landmenu"),
	PRICELAND("priceland"),
	BUYLAND("buyland"),
	LEASELAND("leaseland"),
	LEASE("lease"),
	RENEWLEASE("renewlease"),
	SELLLAND("sellland"),
	LISTLAND("listland"),
	LISTLEASE("listleases"),
	LISTINGS("listings"),
	FLAGLAND("flagland"),
	LANDINFO("landinfo"),
	ADDMEMBERLAND("addmember"),
	REMOVEMEMBERLAND("removemember"),
	ADDOWNERLAND("addowner"),
	REMOVEOWNERLAND("removeowner"),
	BUYATM("buyatm");

	private String command;

	private LandCommand(String command){
		this.command = command;
	}
	
	public String getCommand(){
		return command;
	}
}
