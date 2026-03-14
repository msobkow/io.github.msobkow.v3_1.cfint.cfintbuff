
// Description: Java 25 Default Factory implementation for MimeType buffers

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
 *	CFIntBuffMimeTypeFactory implementation of ICFIntMimeTypeFactory for MimeType
 */
public class CFIntBuffMimeTypeDefaultFactory
	implements ICFIntMimeTypeFactory
{
	public CFIntBuffMimeTypeDefaultFactory() {
	}

	@Override
	public ICFIntMimeTypeHPKey newHPKey() {
		ICFIntMimeTypeHPKey hpkey =
			new CFIntBuffMimeTypeHPKey();
		return( hpkey );
	}

	public CFIntBuffMimeTypeHPKey ensureHPKey(ICFIntMimeTypeHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffMimeTypeHPKey) {
			return( (CFIntBuffMimeTypeHPKey)key );
		}
		else {
			CFIntBuffMimeTypeHPKey mapped = new CFIntBuffMimeTypeHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredMimeTypeId( key.getRequiredMimeTypeId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMimeTypeByUNameIdxKey newByUNameIdxKey() {
		ICFIntMimeTypeByUNameIdxKey key =
			new CFIntBuffMimeTypeByUNameIdxKey();
		return( key );
	}

	public CFIntBuffMimeTypeByUNameIdxKey ensureByUNameIdxKey(ICFIntMimeTypeByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffMimeTypeByUNameIdxKey) {
			return( (CFIntBuffMimeTypeByUNameIdxKey)key );
		}
		else {
			CFIntBuffMimeTypeByUNameIdxKey mapped = new CFIntBuffMimeTypeByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMimeType newRec() {
		ICFIntMimeType rec =
			new CFIntBuffMimeType();
		return( rec );
	}

	public CFIntBuffMimeType ensureRec(ICFIntMimeType rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffMimeType) {
			return( (CFIntBuffMimeType)rec );
		}
		else {
			CFIntBuffMimeType mapped = new CFIntBuffMimeType();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntMimeTypeH newHRec() {
		ICFIntMimeTypeH hrec =
			new CFIntBuffMimeTypeH();
		return( hrec );
	}

	public CFIntBuffMimeTypeH ensureHRec(ICFIntMimeTypeH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffMimeTypeH) {
			return( (CFIntBuffMimeTypeH)hrec );
		}
		else {
			CFIntBuffMimeTypeH mapped = new CFIntBuffMimeTypeH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
