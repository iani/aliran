/* 29 Jan 2021 09:47
Add state without adding variables.
See discussion in https://github.com/iani/sc-hacks-redux/blob/master/README.org
*/

+ Event {
	asController {
		var c;
		c = Controller();
		this keysValuesDo: { | key, value | c[key] = value };
		^c;
	}
}

+ Class {
	atLib { | key ... args |
		^Library.clobal.at(this, key) ?? { this.new(*args) }
	}
}
