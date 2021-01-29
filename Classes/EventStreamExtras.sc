/* 29 Jan 2021 09:40
Extra features for EventStream
*/

/*
+ EventStream {
	// play using a tr synth for timing (instead of own dur stream).
	addTrig { | id |
		var trig;
		id ?? { id = UniqueID.next };
		trig = OSCTrig.atLib(id, id);
		this.addController((
			
		)).onRemove({ | who, what, argId |
			if (argID == trig.id) { trig.remove(this) };
		})
	}
	
}
*/