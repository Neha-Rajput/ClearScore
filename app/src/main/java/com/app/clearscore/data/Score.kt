package com.app.clearscore.data


data class Score(
    val accountIDVStatus: String = "",
    val augmentedCreditScore: Any? = null,
    val coachingSummary: CoachingSummary = CoachingSummary(),
    val creditReportInfo: CreditReportInfo = CreditReportInfo(),
    val dashboardStatus: String = "",
    val personaType: String = ""
)