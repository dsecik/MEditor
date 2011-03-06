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
package cz.fi.muni.xkremser.editor.server;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;

import cz.fi.muni.xkremser.editor.client.Constants;
import cz.fi.muni.xkremser.editor.client.NameTokens;
import cz.fi.muni.xkremser.editor.server.config.EditorConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class URLS.
 */
public class URLS {

	@Inject
	private static EditorConfiguration config;

	/** The Constant LOCALHOST. */
	public static boolean LOCALHOST() {
		return config.isLocalhost();
	};

	/** The Constant ROOT. */
	public static final String ROOT = "";
	// public static final String ROOT = "/skin1";

	/** The Constant MAIN_PAGE. */
	public static final String MAIN_PAGE = "/MEditor.html";

	/** The Constant LOGIN_PAGE. */
	public static final String LOGIN_PAGE = "/login.html";

	/** The Constant INFO_PAGE. */
	public static final String INFO_PAGE = "/info.html";

	public static final String ICON = "/favicon.ico";

	public static final String FLAGS = "/flags.gif";

	public static final String CSS = "/MEditor.css";

	public static final String REQUEST_PREFIX = "/request";

	/** The Constant AUTH_SERVLET. */
	public static final String AUTH_SERVLET = "/auth";

	public static Set<String> nonRestricted = new HashSet<String>() {
		{
			add(LOGIN_PAGE);
			add(INFO_PAGE);
			add(AUTH_SERVLET);
			add(CSS);
			add(ICON);
			add(FLAGS);
		}
	};

	/**
	 * Redirect.
	 * 
	 * @param resp
	 *          the resp
	 * @param where
	 *          the where
	 */
	public static void redirect(HttpServletResponse resp, String where) {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		resp.setHeader("Location", where);
	}

	/**
	 * Convert to ajaxurl.
	 * 
	 * @param parameters
	 *          the parameters
	 * @return the string
	 */
	public static String convertToAJAXURL(Map parameters) {
		StringBuilder sufix = new StringBuilder();
		sufix.append('#');
		if (parameters.containsKey(Constants.URL_PARAM_UUID)) {
			sufix.append(NameTokens.MODIFY + ";");
		}
		for (Object keyObj : parameters.keySet()) {
			sufix.append(keyObj);
			String[] values = (String[]) parameters.get(keyObj);
			if (values.length > 0 && !"".equals(values[0])) {
				sufix.append('=').append(values[0]);
			}
			sufix.append(';');
		}
		return sufix.toString();
	}
}