/* 29 Jan 2021 09:40
Extra features for EventStream
*/

+ EventStream {
	// play using a tr synth for timing (instead of own dur stream).
	addTrig { | id |
		var trig;
		id ?? { id = UniqueID.next };
		trig = OSCTrig.obtain(id, id);
		this.addNotifier(trig, \trig, { | n ... args |
			this.next.play(n, *args); 
		});
		trig.addTriggered(this);
	}

	removeTrig { | id |
		var trig;
		(trig = OSCTrig.access(id)) !? {
			trig.removeTriggered(this);
			this.removeNotifier(trig, \trig);
		}
	}

}
