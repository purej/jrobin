/* ============================================================
 * JRobin : Pure java implementation of RRDTool's functionality
 * ============================================================
 *
 * Project Info:  http://www.jrobin.org
 * Project Lead:  Sasa Markovic (saxon@jrobin.org);
 *
 * (C) Copyright 2003, by Sasa Markovic.
 *
 * Developers:    Sasa Markovic (saxon@jrobin.org)
 *                Arne Vandamme (cobralord@jrobin.org)
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package org.jrobin.core;

import java.io.IOException;

/**
 * Factory class which creates actual {@link RrdNioBackend} objects.
 */
public class RrdNioBackendFactory extends RrdFileBackendFactory{
	/** factory name, "NIO" */
	public static final String NAME = "NIO";

	/**
	 * Creates RrdNioBackend object for the given file path.
	 * @param path File path
	 * @param readOnly True, if the file should be accessed in read/only mode.
	 * False otherwise.
	 * @param lockMode One of the following constants: {@link RrdDb.NO_LOCKS},
	 * {@link RrdDb.EXCEPTION_IF_LOCKED} or {@link RrdDb.WAIT_IF_LOCKED}.
	 * @return RrdNioBackend object which handles all I/O operations for the given file path
	 * @throws IOException Thrown in case of I/O error.
	 */
	protected RrdBackend open(String path, boolean readOnly, int lockMode) throws IOException {
		return new RrdNioBackend(path, readOnly, lockMode);
	}

	/**
	 * Returns the name of this factory.
	 * @return Factory name (equals to string "NIO")
	 */
	protected String getFactoryName() {
		return NAME;    
	}
}
