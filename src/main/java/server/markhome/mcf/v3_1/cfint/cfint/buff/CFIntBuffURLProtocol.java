// Description: Java 25 implementation of a URLProtocol buffer

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
import java.io.*;
import java.math.*;
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

public class CFIntBuffURLProtocol
	implements ICFIntURLProtocol, Comparable<Object>, Serializable
{
	protected int requiredURLProtocolId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFIntURLProtocol.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFIntURLProtocol.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredName;
	protected String requiredDescription;
	protected boolean requiredIsSecure;

	public CFIntBuffURLProtocol() {
		requiredURLProtocolId = ICFIntURLProtocol.URLPROTOCOLID_INIT_VALUE;
		requiredName = ICFIntURLProtocol.NAME_INIT_VALUE;
		requiredDescription = ICFIntURLProtocol.DESCRIPTION_INIT_VALUE;
		requiredIsSecure = ICFIntURLProtocol.ISSECURE_INIT_VALUE;
	}

	@Override
	public Integer getPKey() {
		return getRequiredURLProtocolId();
	}

	@Override
	public void setPKey(Integer requiredURLProtocolId) {
		this.requiredURLProtocolId = requiredURLProtocolId;
	}

	@Override
	public int getRequiredURLProtocolId() {
		return( requiredURLProtocolId );
	}

	@Override
	public void setRequiredURLProtocolId( int value ) {
		if( value < ICFIntURLProtocol.URLPROTOCOLID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredURLProtocolId",
				1,
				"value",
				value,
				ICFIntURLProtocol.URLPROTOCOLID_MIN_VALUE );
		}
		requiredURLProtocolId = value;
	}

	@Override
	public CFLibDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public CFLibDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}
	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( ICFIntURLProtocol.CLASS_CODE );
	}

	@Override
	public String getRequiredName() {
		return( requiredName );
	}

	@Override
	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 16 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		requiredName = value;
	}

	@Override
	public String getRequiredDescription() {
		return( requiredDescription );
	}

	@Override
	public void setRequiredDescription( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDescription",
				1,
				"value" );
		}
		else if( value.length() > 50 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDescription",
				1,
				"value.length()",
				value.length(),
				50 );
		}
		requiredDescription = value;
	}

	@Override
	public boolean getRequiredIsSecure() {
		return( requiredIsSecure );
	}

	@Override
	public void setRequiredIsSecure( boolean value ) {
		requiredIsSecure = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFIntURLProtocol ) {
			ICFIntURLProtocol rhs = (ICFIntURLProtocol)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredURLProtocolId() != rhs.getRequiredURLProtocolId() ) {
				return( false );
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredDescription() != null ) {
				if( rhs.getRequiredDescription() != null ) {
					if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFIntURLProtocolH ) {
			ICFIntURLProtocolH rhs = (ICFIntURLProtocolH)obj;
			if( getRequiredURLProtocolId() != rhs.getRequiredURLProtocolId() ) {
				return( false );
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredDescription() != null ) {
				if( rhs.getRequiredDescription() != null ) {
					if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFIntURLProtocolHPKey ) {
			ICFIntURLProtocolHPKey rhs = (ICFIntURLProtocolHPKey)obj;
			if( getRequiredURLProtocolId() != rhs.getRequiredURLProtocolId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFIntURLProtocolByUNameIdxKey ) {
			ICFIntURLProtocolByUNameIdxKey rhs = (ICFIntURLProtocolByUNameIdxKey)obj;
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntURLProtocolByIsSecureIdxKey ) {
			ICFIntURLProtocolByIsSecureIdxKey rhs = (ICFIntURLProtocolByIsSecureIdxKey)obj;
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
				return( false );
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + getRequiredURLProtocolId();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getRequiredDescription() != null ) {
			hashCode = hashCode + getRequiredDescription().hashCode();
		}
		if( getRequiredIsSecure() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFIntURLProtocol ) {
			ICFIntURLProtocol rhs = (ICFIntURLProtocol)obj;
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredURLProtocolId() < rhs.getRequiredURLProtocolId() ) {
				return( -1 );
			}
			else if( getRequiredURLProtocolId() > rhs.getRequiredURLProtocolId() ) {
				return( 1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredDescription() != null) {
				if (rhs.getRequiredDescription() != null) {
					cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDescription() != null) {
				return( -1 );
			}
			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFIntURLProtocolHPKey ) {
			ICFIntURLProtocolHPKey rhs = (ICFIntURLProtocolHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getRequiredURLProtocolId() < rhs.getRequiredURLProtocolId() ) {
				return( -1 );
			}
			else if( getRequiredURLProtocolId() > rhs.getRequiredURLProtocolId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFIntURLProtocolH ) {
			ICFIntURLProtocolH rhs = (ICFIntURLProtocolH)obj;
			cmp = 0;
			if( getRequiredURLProtocolId() < rhs.getRequiredURLProtocolId() ) {
				return( -1 );
			}
			else if( getRequiredURLProtocolId() > rhs.getRequiredURLProtocolId() ) {
				return( 1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredDescription() != null) {
				if (rhs.getRequiredDescription() != null) {
					cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDescription() != null) {
				return( -1 );
			}
			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFIntURLProtocolByUNameIdxKey ) {
			ICFIntURLProtocolByUNameIdxKey rhs = (ICFIntURLProtocolByUNameIdxKey)obj;

			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFIntURLProtocolByIsSecureIdxKey ) {
			ICFIntURLProtocolByIsSecureIdxKey rhs = (ICFIntURLProtocolByIsSecureIdxKey)obj;

			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFIntURLProtocol src ) {
		setURLProtocol( src );
	}

	@Override
	public void setURLProtocol( ICFIntURLProtocol src ) {
		setRequiredURLProtocolId(src.getRequiredURLProtocolId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredName(src.getRequiredName());
		setRequiredDescription(src.getRequiredDescription());
		setRequiredIsSecure(src.getRequiredIsSecure());
	}

	@Override
	public void set( ICFIntURLProtocolH src ) {
		setURLProtocol( src );
	}

	@Override
	public void setURLProtocol( ICFIntURLProtocolH src ) {
		setRequiredURLProtocolId(src.getRequiredURLProtocolId());
		setRequiredName(src.getRequiredName());
		setRequiredDescription(src.getRequiredDescription());
		setRequiredIsSecure(src.getRequiredIsSecure());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredURLProtocolId=" + "\"" + Integer.toString( getRequiredURLProtocolId() ) + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredURLProtocolId=" + "\"" + Integer.toString( getRequiredURLProtocolId() ) + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " RequiredDescription=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredDescription() ) + "\""
			+ " RequiredIsSecure=" + (( getRequiredIsSecure() ) ? "\"true\"" : "\"false\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFIntBuffURLProtocol" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
