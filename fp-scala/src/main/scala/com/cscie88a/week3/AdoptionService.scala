package com.cscie88a.week3

// complete the method definitions below
object AdoptionService {
  def tryToAdoptNoArg(
      isAdoptionFeePaid: Boolean
    )(
      readyForAdoptionNoArg: () => Boolean
    ): Boolean = {
      if (readyForAdoptionNoArg() && isAdoptionFeePaid) {
        return true
      } else {
        return false
      }
  }: Boolean

  def tryToAdoptOneArg(
      healthCheckDone: Boolean,
      isAdoptionFeePaid: Boolean
    )(
      readyForAdoptionOneArg: Boolean => Boolean
    ): Boolean = {
    if (readyForAdoptionOneArg(healthCheckDone) && isAdoptionFeePaid) {
      true
    } else {
      false
    }
  }

}
