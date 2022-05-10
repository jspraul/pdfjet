package pdfjet

/**
 * field.go
 *
Copyright 2022 Innovatics Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

// Field describes field object that is used from the Form class.
// Please see Example_45
type Field struct {
	x              float32
	values         []string
	altDescription []string
	actualText     []string
	format         bool
}

// NewField constructs field object.
func NewField(x float32, values []string, format bool) *Field {
	field := new(Field)
	field.x = x
	field.values = values
	field.format = format
	if values != nil {
		field.altDescription = values
		field.actualText = values
		for i := 0; i < len(values); i++ {
			field.altDescription[i] = values[i]
			field.actualText[i] = values[i]
		}
	}
	return field
}

// SetAltDescription sets the alt description.
func (field *Field) SetAltDescription(altDescription string) *Field {
	field.altDescription[0] = altDescription
	return field
}

// SetActualText sets the alt description.
func (field *Field) SetActualText(actualText string) *Field {
	field.actualText[0] = actualText
	return field
}
