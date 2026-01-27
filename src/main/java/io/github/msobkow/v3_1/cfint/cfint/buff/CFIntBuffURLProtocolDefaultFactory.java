
// Description: Java 25 Default Factory implementation for URLProtocol buffers

/*
 *	io.github.msobkow.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
 *	
 *	Mark's Code Fractal CFInt is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFInt is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFInt is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFInt.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 *	
 */

package io.github.msobkow.v3_1.cfint.cfint.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cflib.xml.CFLibXmlUtil;
import io.github.msobkow.v3_1.cfsec.cfsec.*;
import io.github.msobkow.v3_1.cfint.cfint.*;
import io.github.msobkow.v3_1.cfsec.cfsec.buff.*;

/*
 *	CFIntBuffURLProtocolFactory implementation of ICFIntURLProtocolFactory for URLProtocol
 */
public class CFIntBuffURLProtocolDefaultFactory
	implements ICFIntURLProtocolFactory
{
	public CFIntBuffURLProtocolDefaultFactory() {
	}

	@Override
	public ICFIntURLProtocolHPKey newHPKey() {
		ICFIntURLProtocolHPKey hpkey =
			new CFIntBuffURLProtocolHPKey();
		return( hpkey );
	}

	public CFIntBuffURLProtocolHPKey ensureHPKey(ICFIntURLProtocolHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffURLProtocolHPKey) {
			return( (CFIntBuffURLProtocolHPKey)key );
		}
		else {
			CFIntBuffURLProtocolHPKey mapped = new CFIntBuffURLProtocolHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredURLProtocolId( key.getRequiredURLProtocolId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntURLProtocolByUNameIdxKey newByUNameIdxKey() {
		ICFIntURLProtocolByUNameIdxKey key =
			new CFIntBuffURLProtocolByUNameIdxKey();
		return( key );
	}

	public CFIntBuffURLProtocolByUNameIdxKey ensureByUNameIdxKey(ICFIntURLProtocolByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffURLProtocolByUNameIdxKey) {
			return( (CFIntBuffURLProtocolByUNameIdxKey)key );
		}
		else {
			CFIntBuffURLProtocolByUNameIdxKey mapped = new CFIntBuffURLProtocolByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntURLProtocolByIsSecureIdxKey newByIsSecureIdxKey() {
		ICFIntURLProtocolByIsSecureIdxKey key =
			new CFIntBuffURLProtocolByIsSecureIdxKey();
		return( key );
	}

	public CFIntBuffURLProtocolByIsSecureIdxKey ensureByIsSecureIdxKey(ICFIntURLProtocolByIsSecureIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffURLProtocolByIsSecureIdxKey) {
			return( (CFIntBuffURLProtocolByIsSecureIdxKey)key );
		}
		else {
			CFIntBuffURLProtocolByIsSecureIdxKey mapped = new CFIntBuffURLProtocolByIsSecureIdxKey();
			mapped.setRequiredIsSecure( key.getRequiredIsSecure() );
			return( mapped );
		}
	}

	@Override
	public ICFIntURLProtocol newRec() {
		ICFIntURLProtocol rec =
			new CFIntBuffURLProtocol();
		return( rec );
	}

	public CFIntBuffURLProtocol ensureRec(ICFIntURLProtocol rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffURLProtocol) {
			return( (CFIntBuffURLProtocol)rec );
		}
		else {
			CFIntBuffURLProtocol mapped = new CFIntBuffURLProtocol();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntURLProtocolH newHRec() {
		ICFIntURLProtocolH hrec =
			new CFIntBuffURLProtocolH();
		return( hrec );
	}

	public CFIntBuffURLProtocolH ensureHRec(ICFIntURLProtocolH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffURLProtocolH) {
			return( (CFIntBuffURLProtocolH)hrec );
		}
		else {
			CFIntBuffURLProtocolH mapped = new CFIntBuffURLProtocolH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
