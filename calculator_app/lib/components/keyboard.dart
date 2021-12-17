import 'package:flutter/material.dart';
import 'button.dart';
import 'button_row.dart';

class Keyboard extends StatelessWidget {
  final void Function(String) fn;

  Keyboard(this.fn);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 500,
      child: Column(
        children: [
          ButtonRow([
            Button.big(text: 'AC', fn: fn, color: Button.DARK),
            Button(text: '%', fn: fn, color: Button.DARK),
            Button.operation(text: '/', fn: fn),
          ]),
          SizedBox(
            height: 1,
          ),
          ButtonRow([
            Button(text: '7', fn: fn),
            Button(text: '8', fn: fn),
            Button(text: '9', fn: fn),
            Button.operation(text: 'x', fn: fn),
          ]),
          SizedBox(
            height: 1,
          ),
          ButtonRow([
            Button(text: '4', fn: fn),
            Button(text: '5', fn: fn),
            Button(text: '6', fn: fn),
            Button.operation(text: '-', fn: fn),
          ]),
          SizedBox(
            height: 1,
          ),
          ButtonRow([
            Button(text: '1', fn: fn),
            Button(text: '2', fn: fn),
            Button(text: '6', fn: fn),
            Button.operation(text: '+', fn: fn),
          ]),
          SizedBox(
            height: 1,
          ),
          ButtonRow([
            Button.big(text: '0', fn: fn),
            Button(text: '.', fn: fn),
            Button.operation(text: '=', fn: fn),
          ]),
        ],
      ),
    );
  }
}
