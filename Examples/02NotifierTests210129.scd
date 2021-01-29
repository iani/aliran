/* 29 Jan 2021 13:57
Testing new implementation of Notifier (replacing Notification).
*/

\listener.addNotifier(\notifier, \message, { | ... args | args.postln; });
{ | i | \notifier.changed(\message, i); } ! 10;
\listener.removeNotifier(\notifier, \message);
{ | i | \notifier.changed(\message, i); } ! 10;
//:
\listener.addNotifierOneShot(\notifier, \message, { | ... args | args.postln; });
{ | i | \notifier.changed(\message, i + 1000); } ! 10;
