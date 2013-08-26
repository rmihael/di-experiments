package com.experiments.di.dogs

trait DogsRepository {
  def getByName(name: String): Dog
  def getAllByColor(color: String): Set[Dog]
}
