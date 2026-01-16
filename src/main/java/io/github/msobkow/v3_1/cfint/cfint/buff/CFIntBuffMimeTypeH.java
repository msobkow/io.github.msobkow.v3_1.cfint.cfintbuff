// Description: Java 25 implementation of a MimeType history buffer object

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
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cflib.xml.CFLibXmlUtil;
import io.github.msobkow.v3_1.cfsec.cfsec.*;
import io.github.msobkow.v3_1.cfint.cfint.*;
import io.github.msobkow.v3_1.cfsec.cfsec.buff.*;

public class CFIntBuffMimeTypeH
    implements ICFIntMimeTypeH, Comparable<Object>, Serializable
{
    protected CFIntBuffMimeTypeHPKey pkey;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFIntMimeType.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFIntMimeType.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredName;
	protected String optionalFileTypes;

    public CFIntBuffMimeTypeH() {
            // The primary key member attributes are initialized on construction
            pkey = new CFIntBuffMimeTypeHPKey();
		requiredName = ICFIntMimeType.NAME_INIT_VALUE;
		optionalFileTypes = null;
    }

    @Override
    public int getClassCode() {
            return( ICFIntMimeType.CLASS_CODE );
    }

    @Override
    public CFLibDbKeyHash256 getCreatedByUserId() {
        return( createdByUserId );
    }

    @Override
    public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedByUserId", 1, "value");
        }
        createdByUserId = value;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return( createdAt );
    }

    @Override
    public void setCreatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedAt", 1, "value");
        }
        createdAt = value;
    }

    @Override
    public CFLibDbKeyHash256 getUpdatedByUserId() {
        return( updatedByUserId );
    }

    @Override
    public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedByUserId", 1, "value");
        }
        updatedByUserId = value;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return( updatedAt );
    }

    @Override
    public void setUpdatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedAt", 1, "value");
        }
        updatedAt = value;
    }

    @Override
    public ICFIntMimeTypeHPKey getPKey() {
        return( pkey );
    }

    @Override
    public void setPKey( ICFIntMimeTypeHPKey pkey ) {
        if (pkey != null) {
            if (pkey instanceof CFIntBuffMimeTypeHPKey) {
                this.pkey = (CFIntBuffMimeTypeHPKey)pkey;
            }
            else {
                throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFIntBuffMimeTypeHPKey");
            }
        }
    }

    @Override
    public long getAuditClusterId() {
        return pkey.getAuditClusterId();
    }

    @Override
    public void setAuditClusterId(long auditClusterId) {
        pkey.setAuditClusterId(auditClusterId);
    }

    @Override
    public LocalDateTime getAuditStamp() {
        return pkey.getAuditStamp();
    }

    @Override
    public void setAuditStamp(LocalDateTime auditStamp) {
        pkey.setAuditStamp(auditStamp);
    }

    @Override
    public short getAuditActionId() {
        return pkey.getAuditActionId();
    }

    @Override
    public void setAuditActionId(short auditActionId) {
        pkey.setAuditActionId(auditActionId);
    }

    @Override
    public int getRequiredRevision() {
        return pkey.getRequiredRevision();
    }

    @Override
    public void setRequiredRevision(int revision) {
        pkey.setRequiredRevision(revision);
    }

    @Override
    public CFLibDbKeyHash256 getAuditSessionId() {
        return pkey.getAuditSessionId();
    }

    @Override
    public void setAuditSessionId(CFLibDbKeyHash256 auditSessionId) {
        pkey.setAuditSessionId(auditSessionId);
    }

    @Override
    public int getRequiredMimeTypeId() {
        return( pkey.getRequiredMimeTypeId() );
    }

    @Override
    public void setRequiredMimeTypeId( int requiredMimeTypeId ) {
        pkey.setRequiredMimeTypeId( requiredMimeTypeId );
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
		else if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		requiredName = value;
	}

	@Override
	public String getOptionalFileTypes() {
		return( optionalFileTypes );
	}

	@Override
	public void setOptionalFileTypes( String value ) {
		if( value != null && value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalFileTypes",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		optionalFileTypes = value;
	}

    @Override
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof ICFIntMimeType) {
            ICFIntMimeType rhs = (ICFIntMimeType)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
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
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					if( ! getOptionalFileTypes().equals( rhs.getOptionalFileTypes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFIntMimeTypeH) {
            ICFIntMimeTypeH rhs = (ICFIntMimeTypeH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
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
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					if( ! getOptionalFileTypes().equals( rhs.getOptionalFileTypes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFIntMimeTypeHPKey) {
		ICFIntMimeTypeHPKey rhs = (ICFIntMimeTypeHPKey)obj;
			if( getRequiredMimeTypeId() != rhs.getRequiredMimeTypeId() ) {
				return( false );
			}
		return( true );
        }
        else if (obj instanceof ICFIntMimeTypeByUNameIdxKey) {
            ICFIntMimeTypeByUNameIdxKey rhs = (ICFIntMimeTypeByUNameIdxKey)obj;
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
        else {
			return( false );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = pkey.hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalFileTypes() != null ) {
			hashCode = hashCode + getOptionalFileTypes().hashCode();
		}
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof ICFIntMimeType) {
		ICFIntMimeType rhs = (ICFIntMimeType)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
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
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					cmp = getOptionalFileTypes().compareTo( rhs.getOptionalFileTypes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof ICFIntMimeTypeHPKey) {
        if (getPKey() != null) {
            return( getPKey().compareTo( obj ));
        }
        else {
            return( -1 );
        }
        }
        else if (obj instanceof ICFIntMimeTypeH) {
		ICFIntMimeTypeH rhs = (ICFIntMimeTypeH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
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
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					cmp = getOptionalFileTypes().compareTo( rhs.getOptionalFileTypes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof ICFIntMimeTypeByUNameIdxKey ) {
            ICFIntMimeTypeByUNameIdxKey rhs = (ICFIntMimeTypeByUNameIdxKey)obj;
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
            return( 0 );
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
    public void set( ICFIntMimeType src ) {
		setMimeType( src );
    }

	@Override
    public void setMimeType( ICFIntMimeType src ) {
		setRequiredMimeTypeId( src.getRequiredMimeTypeId() );
		setRequiredName( src.getRequiredName() );
		setOptionalFileTypes( src.getOptionalFileTypes() );
		setRequiredRevision( src.getRequiredRevision() );
    }

	@Override
    public void set( ICFIntMimeTypeH src ) {
		setMimeType( src );
    }

	@Override
    public void setMimeType( ICFIntMimeTypeH src ) {
		setRequiredMimeTypeId( src.getRequiredMimeTypeId() );
		setRequiredName( src.getRequiredName() );
		setOptionalFileTypes( src.getOptionalFileTypes() );
		setRequiredRevision( src.getRequiredRevision() );
    }

    public String getXmlAttrFragment() {
        String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalFileTypes=" + ( ( getOptionalFileTypes() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalFileTypes() ) + "\"" );
        return( ret );
    }

    public String toString() {
        String ret = "<CFIntBuffMimeTypeH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
