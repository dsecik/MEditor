/*
 * Metadata Editor
 * 
 * Metadata Editor - Rich internet application for editing metadata.
 * Copyright (C) 2011  Matous Jobanek (matous.jobanek@mzk.cz)
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

package cz.mzk.editor.server.DAO;

/**
 * @author Matous Jobanek
 * @version Oct 23, 2012
 */
public interface LogInOutDAO {

    /**
     * Log in out.
     * 
     * @param userId
     *        the user id
     * @param logIn
     *        the log in
     * @throws DatabaseException
     *         the database exception
     */
    void logInOut(Long userId, boolean logIn) throws DatabaseException;

    /**
     * Log in out.
     * 
     * @param logIn
     *        the log in
     * @param userId
     *        the user id
     * @throws DatabaseException
     *         the database exception
     */
    void logInOut(boolean logIn, Long userId) throws DatabaseException;

}
