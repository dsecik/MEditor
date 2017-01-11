/*
 * Metadata Editor
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

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import cz.mzk.editor.shared.rpc.NewDigitalObject;

/**
 * @author Jiri Kremser
 * @version 14.11.2011
 */
@GenDispatch(isSecure = false)
@SuppressWarnings("unused")
public class InsertNewDigitalObject {

    /** The detail. */
    @In(1)
    private NewDigitalObject object;

    /** The path to the directory with original images */
    @In(2)
    private String inputPath;

    @In(3)
    private boolean reindex;

    @Out(1)
    private boolean ingestSuccess;

    @Out(2)
    private boolean reindexSuccess;

    @Out(3)
    private String newPid;

}
