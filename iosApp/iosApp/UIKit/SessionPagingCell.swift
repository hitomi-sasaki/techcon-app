//
//  SessionPagingCell.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/24.
//

import Parchment

class SessionPagingCell: PagingCell {
  private let label = UILabel()

  override init(frame: CGRect) {
    super.init(frame: frame)
    setup()
  }

  required init?(coder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }

  private func setup() {
    contentView.addSubview(label)
    label.translatesAutoresizingMaskIntoConstraints = false
    label.centerXAnchor.constraint(equalTo: contentView.centerXAnchor).isActive = true
    label.centerYAnchor.constraint(equalTo: contentView.centerYAnchor).isActive = true
  }

  override func setPagingItem(_ pagingItem: PagingItem, selected: Bool, options: PagingOptions) {
    label.text = (pagingItem as? PagingIndexItem)?.title
    if selected {
      label.font = .systemFont(ofSize: 12.0, weight: .bold)
      label.textColor = .darkGray // TODO: きちんと色合わせる
    } else {
      label.font = .systemFont(ofSize: 12.0, weight: .regular)
      label.textColor = .gray // TODO: きちんと色合わせる
    }
  }
}
