
// Description: Java 25 Default Factory implementation for TopDomain buffers

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
 *	CFIntBuffTopDomainFactory implementation of ICFIntTopDomainFactory for TopDomain
 */
public class CFIntBuffTopDomainDefaultFactory
	implements ICFIntTopDomainFactory
{
	public CFIntBuffTopDomainDefaultFactory() {
	}

	@Override
	public ICFIntTopDomainHPKey newHPKey() {
		ICFIntTopDomainHPKey hpkey =
			new CFIntBuffTopDomainHPKey();
		return( hpkey );
	}

	public CFIntBuffTopDomainHPKey ensureHPKey(ICFIntTopDomainHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffTopDomainHPKey) {
			return( (CFIntBuffTopDomainHPKey)key );
		}
		else {
			CFIntBuffTopDomainHPKey mapped = new CFIntBuffTopDomainHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainByTenantIdxKey newByTenantIdxKey() {
		ICFIntTopDomainByTenantIdxKey key =
			new CFIntBuffTopDomainByTenantIdxKey();
		return( key );
	}

	public CFIntBuffTopDomainByTenantIdxKey ensureByTenantIdxKey(ICFIntTopDomainByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopDomainByTenantIdxKey) {
			return( (CFIntBuffTopDomainByTenantIdxKey)key );
		}
		else {
			CFIntBuffTopDomainByTenantIdxKey mapped = new CFIntBuffTopDomainByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainByTldIdxKey newByTldIdxKey() {
		ICFIntTopDomainByTldIdxKey key =
			new CFIntBuffTopDomainByTldIdxKey();
		return( key );
	}

	public CFIntBuffTopDomainByTldIdxKey ensureByTldIdxKey(ICFIntTopDomainByTldIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopDomainByTldIdxKey) {
			return( (CFIntBuffTopDomainByTldIdxKey)key );
		}
		else {
			CFIntBuffTopDomainByTldIdxKey mapped = new CFIntBuffTopDomainByTldIdxKey();
			mapped.setRequiredTldId( key.getRequiredTldId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainByNameIdxKey newByNameIdxKey() {
		ICFIntTopDomainByNameIdxKey key =
			new CFIntBuffTopDomainByNameIdxKey();
		return( key );
	}

	public CFIntBuffTopDomainByNameIdxKey ensureByNameIdxKey(ICFIntTopDomainByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopDomainByNameIdxKey) {
			return( (CFIntBuffTopDomainByNameIdxKey)key );
		}
		else {
			CFIntBuffTopDomainByNameIdxKey mapped = new CFIntBuffTopDomainByNameIdxKey();
			mapped.setRequiredTldId( key.getRequiredTldId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomain newRec() {
		ICFIntTopDomain rec =
			new CFIntBuffTopDomain();
		return( rec );
	}

	public CFIntBuffTopDomain ensureRec(ICFIntTopDomain rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffTopDomain) {
			return( (CFIntBuffTopDomain)rec );
		}
		else {
			CFIntBuffTopDomain mapped = new CFIntBuffTopDomain();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainH newHRec() {
		ICFIntTopDomainH hrec =
			new CFIntBuffTopDomainH();
		return( hrec );
	}

	public CFIntBuffTopDomainH ensureHRec(ICFIntTopDomainH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffTopDomainH) {
			return( (CFIntBuffTopDomainH)hrec );
		}
		else {
			CFIntBuffTopDomainH mapped = new CFIntBuffTopDomainH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
