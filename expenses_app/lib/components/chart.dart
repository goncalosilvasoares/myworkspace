import 'package:expenses_app/models/transaction.dart';
import 'package:intl/intl.dart';
import 'package:flutter/material.dart';

import 'chart_bar.dart';

class Chart extends StatelessWidget {
  final List<Transaction> recentTransactions;

  Chart(this.recentTransactions);

  List<Map<String, Object>> get groupedTransactions {
    return List.generate(7, (index) {
      final weekDay = DateTime.now().subtract(
        Duration(days: index),
      );

      double totalSum = 0.0;
      recentTransactions.forEach((r) => r.date.day == weekDay.day &&
              r.date.month == weekDay.month &&
              r.date.year == weekDay.year
          ? totalSum += r.value
          : null);
      return {
        'day': DateFormat.E().format(weekDay)[0],
        'value': totalSum,
      };
    }).reversed.toList();
  }

  double get _weekTotalValue {
    return groupedTransactions.fold(0.0, (sum, t) {
      return sum + (t['value'] as double);
    });
  }

  @override
  Widget build(BuildContext context) {
    groupedTransactions;
    return Card(
      elevation: 6,
      margin: EdgeInsets.all(20),
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: groupedTransactions.map((t) {
            return Flexible(
              fit: FlexFit.tight,
              child: ChartBar(
                label: t['day'].toString(),
                percentage: _weekTotalValue == 0
                    ? 0
                    : (t['value'] as double) / _weekTotalValue,
                value: t['value'] as double,
              ),
            );
          }).toList(),
        ),
      ),
    );
  }
}
