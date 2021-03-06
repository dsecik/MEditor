/*
 * Metadata Editor
 * @author Jiri Kremser
 * 
 * 
 * 
 * Metadata Editor - Rich internet application for editing metadata.
 * Copyright (C) 2011  Jiri Kremser (kremser@mzk.cz)
 * Moravian Library in Brno
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * 
 */

package cz.mzk.editor.shared.rpc.action;

import java.util.Date;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import cz.mzk.editor.shared.domain.DigitalObjectModel;
import cz.mzk.editor.shared.rpc.DigitalObjectDetail;
import cz.mzk.editor.shared.rpc.StoredItem;

// TODO: Auto-generated Javadoc
/**
 * The Class GetDigitalObjectDetail.
 */
@GenDispatch(isSecure = false)
@SuppressWarnings("unused")
public class GetDigitalObjectDetail {

    /** The uuid. */
    @In(1)
    private String uuid;

    @In(2)
    private DigitalObjectModel model;

    /**
     * The stored FOXML file, <code>savedEditedObject == null</code> when the
     * digital object has to be obtained from Fedora.
     */
    @In(3)
    private StoredItem savedEditedObject;

    /** The detail. */
    @Out(1)
    private DigitalObjectDetail detail;

    /** The description. */
    @Out(2)
    private String description;

    @Out(3)
    private Date modified;

}
