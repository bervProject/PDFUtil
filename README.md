# PDFUtil

PDF Utilization

## Dependencies

* `org.apache.pdfbox`

## Command

Assuming you are using executable from the `build\distributions\<name>.zip` or `build\distributions\<name>.tar`.

### Merge

Merge operation ordered by name.

```bash
PDFUtil "merge" "<source dir>" "<target file>"
```

### Open Password

Password will be asked later.

```bash
PDFUtil "removePwd" "<source file>" "target file"
```

## LICENSE

Apache 2.0

```markdown
   Copyright 2022 Bervianto Leo Pratama

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```