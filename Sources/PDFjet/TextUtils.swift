/**
 *  TextUtils.swift
 *
Copyright 2023 Innovatics Inc.

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
import Foundation

///
/// Text processing utilities.
///
public class TextUtils {
    public static func splitTextIntoTokens(
            _ text: String,
            _ font: Font,
            _ fallbackFont: Font?,
            _ width: Float) -> [String] {
        var tokens2 = [String]()
        let tokens = text.components(separatedBy: .whitespaces)
        for token in tokens {
            if font.stringWidth(fallbackFont, token) <= width {
                tokens2.append(token)
            } else {
                var buf = String()
                for scalar in token.unicodeScalars {
                    let ch = String(scalar)
                    if font.stringWidth(fallbackFont, buf + ch) <= width {
                        buf.append(ch)
                    } else {
                        tokens2.append(buf)
                        buf = ""
                        buf.append(ch)
                    }
                }
                if buf != "" {
                    tokens2.append(buf)
                }
            }
        }
        return tokens2
    }

    public static func printDuration(_ example: String, _ time0: Int64, _ time1: Int64) {
        var duration = String(time1 - time0)
        if duration.count == 1 {
            duration = "   " + duration        
        } else if duration.count == 2 {
            duration = "  " + duration
        } else if duration.count == 3 {
            duration = " " + duration
        }
        duration += ".0"
        print(example + " => " + duration)
    }
}   // End of TextUtils.swift
