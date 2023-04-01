package main

import (
	"fmt"
	"time"

	pdfjet "github.com/edragoev1/pdfjet/src"
	"github.com/edragoev1/pdfjet/src/align"
	"github.com/edragoev1/pdfjet/src/color"
	"github.com/edragoev1/pdfjet/src/letter"
)

// Example73 -- Test case for TextBox
func Example73() {
	pdf := pdfjet.NewPDFFile("Example_73.pdf", 0)

	f1 := pdfjet.NewFontFromFile(pdf, "fonts/Droid/DroidSans.ttf.stream")
	f2 := pdfjet.NewFontFromFile(pdf, "fonts/Droid/DroidSansFallback.ttf.stream")

	f1.SetSize(12.0)
	f2.SetSize(12.0)

	page := pdfjet.NewPageAddTo(pdf, letter.Portrait)

	line1 := pdfjet.NewTextLine(f1, "Hello, Beautiful World")
	line2 := pdfjet.NewTextLine(f1, "Hello,BeautifulWorld")

	textBox := pdfjet.NewTextBox(f1)
	textBox.SetText(line1.GetText())
	textBox.SetMargin(0.0)
	textBox.SetLocation(50.0, 50.0)
	textBox.SetWidth(line1.GetWidth() + 2*textBox.GetMargin())
	textBox.SetBgColor(color.Aliceblue)
	// The drawOn method returns the x and y of the bottom right corner of the TextBox
	xy := textBox.DrawOn(page)

	box := pdfjet.NewBox()
	box.SetLocation(xy[0], xy[1])
	box.SetSize(20.0, 20.0)
	box.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetText(line1.GetText() + "!")
	textBox.SetWidth(line1.GetWidth() + 2*textBox.GetMargin())
	textBox.SetLocation(50.0, 100.0)
	xy = textBox.DrawOn(page)

	box = pdfjet.NewBox()
	box.SetLocation(xy[0], xy[1])
	box.SetSize(20.0, 20.0)
	box.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetText(line2.GetText())
	textBox.SetWidth(line2.GetWidth() + 2*textBox.GetMargin())
	textBox.SetLocation(50.0, 200.0)
	xy = textBox.DrawOn(page)

	box = pdfjet.NewBox()
	box.SetLocation(xy[0], xy[1])
	box.SetSize(20.0, 20.0)
	box.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetText(line2.GetText() + "!")
	textBox.SetWidth(line2.GetWidth() + 2*textBox.GetMargin())
	textBox.SetLocation(50.0, 300.0)
	xy = textBox.DrawOn(page)

	box = pdfjet.NewBox()
	box.SetLocation(xy[0], xy[1])
	box.SetSize(20.0, 20.0)
	box.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetText(line2.GetText() + "! Left Align")
	textBox.SetMargin(10.0)
	textBox.SetWidth(line2.GetWidth() + 2*textBox.GetMargin())
	textBox.SetLocation(50.0, 400.0)
	xy = textBox.DrawOn(page)

	box = pdfjet.NewBox()
	box.SetLocation(xy[0], xy[1])
	box.SetSize(20.0, 20.0)
	box.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetText(line2.GetText() + "! Right Align")
	textBox.SetMargin(10.0)
	textBox.SetTextAlignment(align.Right)
	textBox.SetWidth(line2.GetWidth() + 2*textBox.GetMargin())
	textBox.SetLocation(50.0, 500.0)
	xy = textBox.DrawOn(page)

	box = pdfjet.NewBox()
	box.SetLocation(xy[0], xy[1])
	box.SetSize(20.0, 20.0)
	box.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetText(line2.GetText() + "! Center")
	textBox.SetMargin(10.0)
	textBox.SetTextAlignment(align.Center)
	textBox.SetWidth(line2.GetWidth() + 2*textBox.GetMargin())
	textBox.SetLocation(50.0, 600.0)
	xy = textBox.DrawOn(page)

	box = pdfjet.NewBox()
	box.SetLocation(xy[0], xy[1])
	box.SetSize(20.0, 20.0)
	box.DrawOn(page)

	text := "保健所によると、女性は１３日に旅行先のタイから札幌に戻り、１６日午後５～８時ごろ同店を訪れ、帰宅後に発熱などの症状 が出て、２３日に医療機関ではしかと診断された。はしかのウイルスは発症日の１日前から感染者の呼吸などから放出され、本人がいなくなっても、２時間>程度空気中に漂い、空気感染する。保健所は１６日午後５～１１時に同店を訪れた人に、発熱などの異常が出た場合、早期にマスクをして医療機関を受診す>るよう呼びかけている。（本郷由美子）"

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetFallbackFont(f2)
	textBox.SetText(text)
	// textBox.SetMargin(10.0)
	textBox.SetBgColor(color.Lightblue)
	textBox.SetVerticalAlignment(align.Top)
	// textBox.SetHeight(210.0)
	textBox.SetHeight(151.0)
	textBox.SetWidth(300.0)
	textBox.SetLocation(250.0, 50.0)
	textBox.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetFallbackFont(f2)
	textBox.SetText(text)
	// textBox.SetMargin(10.0)
	textBox.SetBgColor(color.Lightblue)
	textBox.SetVerticalAlignment(align.Center)
	// textBox.SetHeight(210.0)
	textBox.SetHeight(151.0)
	textBox.SetWidth(300.0)
	textBox.SetLocation(250.0, 300.0)
	textBox.DrawOn(page)

	textBox = pdfjet.NewTextBox(f1)
	textBox.SetFallbackFont(f2)
	textBox.SetText(text)
	// textBox.SetMargin(10f);
	textBox.SetBgColor(color.Lightblue)
	textBox.SetVerticalAlignment(align.Bottom)
	// textBox.SetHeight(210f)
	textBox.SetHeight(151.0)
	textBox.SetWidth(300.0)
	textBox.SetLocation(250.0, 550.0)
	textBox.DrawOn(page)

	pdf.Complete()
}

func main() {
	start := time.Now()
	Example73()
	elapsed := time.Since(start)
	fmt.Printf("Example_73 => %dµs\n", elapsed.Microseconds())
}