package com.kakao.s2graph.core.storage

import com.kakao.s2graph.core._
import com.kakao.s2graph.core.mysqls.Label

import scala.concurrent.Future

trait Storage {
  def getEdges(q: Query): Future[Seq[QueryResult]]

  def checkEdges(params: Seq[(Vertex, Vertex, QueryParam)]): Future[Seq[QueryResult]]

  def getVertices(vertices: Seq[Vertex]): Future[Seq[Vertex]]

  def mutateElements(elements: Seq[GraphElement], withWait: Boolean = false): Future[Seq[Boolean]]

  def mutateEdges(edges: Seq[Edge], withWait: Boolean = false): Future[Seq[Boolean]]

  def mutateVertices(vertices: Seq[Vertex], withWait: Boolean = false): Future[Seq[Boolean]]

  def deleteAllAdjacentEdges(srcVertices: List[Vertex], labels: Seq[Label], dir: Int, ts: Option[Long] = None, walTopic: String): Future[Boolean]

  def incrementCounts(edges: Seq[Edge]): Future[Seq[(Boolean, Long)]]

  def flush(): Unit
}
