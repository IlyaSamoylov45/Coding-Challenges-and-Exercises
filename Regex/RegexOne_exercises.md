Exercise 1: Matching Characters
```
Match	abcdefg
Match	abcde
Match	abc
```
```
[abc].*
abc.*
```
Exercise 1½: Matching Digits
```
Match	abc123xyz
Match	define "123"
Match	var g = 123;
```
```
.*
.+
```
Exercise 2: Matching With Wildcards
```
Match	cat.
Match	896.
Match	?=+.
Skip	abc1
```
```
.*\.
```
Exercise 3: Matching Characters
```
Match	can
Match	man
Match	fan
Skip	dan
Skip	ran
Skip	pan
```
```
[cmf]an
```
Exercise 4: Excluding Characters
```
Match	hog
Match	dog
Skip	bog
```
```
[^b]og
```
Exercise 5: Matching Character Ranges
```
Match	Ana
Match	Bob
Match	Cpc
Skip	aax
Skip	bby
Skip	ccz
```
```
[A-Z][a-z]+
[A-Z][\w]+
[A-Z].*
```
Exercise 6: Matching Repeated Characters
```
Match	wazzzzzup
Match	wazzzup
Skip	wazup
```
```
.*z{2}.*
```
Exercise 7: Matching Repeated Characters
```
Match	aaaabcc
Match	aabbbbc
Match	aacc
Skip	a
```
```
a[abc]+
```
Exercise 8: Matching Optional Characters
```
Match	1 file found?
Match	2 files found?
Match	24 files found?
Skip	No files found.
```
```
[0-9]{1}.+\?
```
Exercise 9: Matching Whitespaces
```
Match	1.   abc
Match	2.	abc
Match	3.           abc
Skip	4.abc
```
```
[\s]+abc
```
Exercise 10: Matching Lines
```
Match	Mission: successful
Skip	Last Mission: unsuccessful
Skip	Next Mission: successful upon capture of target
```
```
^M.*l
```
Exercise 11: Matching Groups
```
Capture	file_record_transcript.pdf
Capture	file_07241999.pdf
Skip	testfile_fake.pdf.tmp
```
```
^(file.*)\.pdf
```
Exercise 12: Matching Nested Groups
```
Capture	Jan 1987
Capture	May 1969
Capture	Aug 2011
```
```
((\w+ )(\d*))
```
Exercise 13: Matching Nested Groups
```
Capture	1280x720
Capture	1920x1600
Capture	1024x768
```
```
(\d{4})x(\d{3,4})
```
Exercise 14: Matching Conditional Text
```
Match	I love cats
Match	I love dogs
Skip	I love logs
Skip	I love cogs
```
```
(I love )(cats|dogs)
```
