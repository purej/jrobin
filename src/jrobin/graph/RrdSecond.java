/* ============================================================
 * JRobin : Pure java implementation of RRDTool's functionality
 * ============================================================
 *
 * Project Info:  http://www.sourceforge.net/projects/jrobin
 * Project Lead:  Sasa Markovic (saxon@eunet.yu);
 *
 * (C) Copyright 2003, by Sasa Markovic.
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

package jrobin.graph;

import com.jrefinery.data.RegularTimePeriod;

import java.util.Calendar;

/**
 *
 */
class RrdSecond extends RegularTimePeriod {
	long timestamp;

	RrdSecond(long timestamp) {
		this.timestamp = timestamp;
	}

	public RegularTimePeriod previous() {
		return new RrdSecond(timestamp - 1);
	}

	public RegularTimePeriod next() {
		return new RrdSecond(timestamp + 1);
	}

	public long getSerialIndex() {
		return timestamp;
	}

	public long getFirstMillisecond(Calendar calendar) {
		return timestamp * 1000L;
	}

	public long getLastMillisecond(Calendar calendar) {
		return timestamp * 1000L + 999L;
	}

	public int compareTo(Object obj) {
        if(obj instanceof RrdSecond) {
			RrdSecond rsec = (RrdSecond) obj;
			if(timestamp < rsec.timestamp) {
				return -1;
			}
			else if (timestamp == rsec.timestamp) {
				return 0;
			}
			else {
				return +1;
			}
		}
		return 1;
	}

	public boolean equals(Object obj) {
		if(obj instanceof RrdSecond) {
			RrdSecond rsec = (RrdSecond) obj;
			return (timestamp == rsec.timestamp);
		}
		return false;
	}

	long getTimestamp() {
		return timestamp;
	}
}
