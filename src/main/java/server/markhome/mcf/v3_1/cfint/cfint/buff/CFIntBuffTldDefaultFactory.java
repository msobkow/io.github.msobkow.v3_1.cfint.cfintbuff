
// Description: Java 25 Default Factory implementation for Tld buffers

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
 *	CFIntBuffTldFactory implementation of ICFIntTldFactory for Tld
 */
public class CFIntBuffTldDefaultFactory
	implements ICFIntTldFactory
{
	public CFIntBuffTldDefaultFactory() {
	}

	@Override
	public ICFIntTldHPKey newHPKey() {
		ICFIntTldHPKey hpkey =
			new CFIntBuffTldHPKey();
		return( hpkey );
	}

	public CFIntBuffTldHPKey ensureHPKey(ICFIntTldHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffTldHPKey) {
			return( (CFIntBuffTldHPKey)key );
		}
		else {
			CFIntBuffTldHPKey mapped = new CFIntBuffTldHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTldByTenantIdxKey newByTenantIdxKey() {
		ICFIntTldByTenantIdxKey key =
			new CFIntBuffTldByTenantIdxKey();
		return( key );
	}

	public CFIntBuffTldByTenantIdxKey ensureByTenantIdxKey(ICFIntTldByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTldByTenantIdxKey) {
			return( (CFIntBuffTldByTenantIdxKey)key );
		}
		else {
			CFIntBuffTldByTenantIdxKey mapped = new CFIntBuffTldByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTldByNameIdxKey newByNameIdxKey() {
		ICFIntTldByNameIdxKey key =
			new CFIntBuffTldByNameIdxKey();
		return( key );
	}

	public CFIntBuffTldByNameIdxKey ensureByNameIdxKey(ICFIntTldByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTldByNameIdxKey) {
			return( (CFIntBuffTldByNameIdxKey)key );
		}
		else {
			CFIntBuffTldByNameIdxKey mapped = new CFIntBuffTldByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTld newRec() {
		ICFIntTld rec =
			new CFIntBuffTld();
		return( rec );
	}

	public CFIntBuffTld ensureRec(ICFIntTld rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffTld) {
			return( (CFIntBuffTld)rec );
		}
		else {
			CFIntBuffTld mapped = new CFIntBuffTld();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntTldH newHRec() {
		ICFIntTldH hrec =
			new CFIntBuffTldH();
		return( hrec );
	}

	public CFIntBuffTldH ensureHRec(ICFIntTldH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffTldH) {
			return( (CFIntBuffTldH)hrec );
		}
		else {
			CFIntBuffTldH mapped = new CFIntBuffTldH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
