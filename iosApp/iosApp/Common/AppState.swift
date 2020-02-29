//
//  AppState.swift
//  iosApp
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import common
import FirebaseAuth

class AppState: common.AppState {
    var token: String? = ""

    init() {
        signIn()
    }

    private func signIn() {
        if let user = Auth.auth().currentUser {
            setToken(from: user)
        } else {
            Auth.auth().signInAnonymously { [weak self] result, error in
                if let result = result {
                    self?.setToken(from: result.user)
                } else if let error = error {
                    dump(error)
                }
            }
        }
    }

    private func setToken(from user: FirebaseAuth.User) {
        user.getIDToken { [weak self] token, _ in
            self?.token = token
        }
    }
}
