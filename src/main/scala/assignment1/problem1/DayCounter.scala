package assignment1.problem1

import java.sql.Date

object DayCounter {

  val listOfMonthsWith31Days = Seq(1, 3, 5, 7, 8, 10, 12)
  val listOfMonthsWith30Days = Seq(4, 6, 9, 11)

  def calculateNumberOfSundays(startYear: Int, endYear: Int): Int = {
    val totalSunday = getSundayCountsRecursive(startYear, endYear, 1, 7, 0)
    print(s"Total number of sundays $totalSunday")
    totalSunday
  }

  def getSundayCountsRecursive(startYear: Int = 1900, endYear: Int, month: Int, currentDay: Int, totalSunday: Int): Int = {
    val isDivisibleBy4 = startYear % 4 == 0
    val isDivisibleBy100 = startYear % 100 == 0
    val isDivisibleBy400 = startYear % 400 == 0

    val isLeapYear = (isDivisibleBy4, isDivisibleBy100, isDivisibleBy400) match {
      case (true, false, _) => true
      case (true, true, true) => true
      case _ => false
    }

    if (startYear == endYear) {
      totalSunday
    } else {
      if (month <= 12) {
        println("The Month is: " + month + " currentDay is :  " + currentDay)
        val sundays = if (currentDay == 7) totalSunday + 1 else totalSunday
        val cday = {
          if (listOfMonthsWith31Days.contains(month)) currentDay + 3
          else if (listOfMonthsWith30Days.contains(month)) currentDay + 2
          else if (month == 2 && isLeapYear) currentDay + 1
          else currentDay
        }
        val validDay = if (cday > 7) cday - 7 else cday
        getSundayCountsRecursive(startYear, endYear, month + 1, validDay, sundays)
      } else {
        println(s"Counting sundays for year:${startYear + 1}, currentDay:$currentDay, got total sundays:$totalSunday")
        getSundayCountsRecursive(startYear + 1, endYear, 1, currentDay, totalSunday)
      }
    }
  }

  def getSundaysUsingLibFun(yearStart: Int, yearEnd: Int): Int = {
    var count = 0
    (yearStart to yearEnd).foreach(year => (1 to 12).foreach(month => if (new Date(year, month, 1).getDay == 6) count += 1))
    count
  }

  def getSundaysUsingLibFunFold(yearStart: Int, yearEnd: Int): Int = {
    def forAYear(year: Int) = {
      (1 to 12).foldLeft(0) {
        (totalSunday, month) => {
          if (new Date(year, month, 1).getDay == 6) totalSunday + 1 else totalSunday
        }
      }
    }

    (yearStart to yearEnd).foldLeft(0) {
      (totalSunday, year) => {
        forAYear(year) + totalSunday
      }
    }
  }

//  print(getSundaysUsingLibFun(1901, 2000))
//  print(getSundaysUsingLibImproved(1901, 2000))
//  calculateNumberOfSundays(1901, 2000)
}
