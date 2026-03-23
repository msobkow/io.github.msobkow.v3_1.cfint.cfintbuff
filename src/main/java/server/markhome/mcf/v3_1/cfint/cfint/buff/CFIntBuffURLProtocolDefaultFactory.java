
// Description: Java 25 Default Factory implementation for URLProtocol buffers

/*
 *	server.markhome.mcf.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfint.cfint.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.buff.*;

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
