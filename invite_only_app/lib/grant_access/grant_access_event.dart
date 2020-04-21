import 'package:equatable/equatable.dart';
import 'package:invite_only_spaces/invite_only_spaces.dart';
import 'package:rsa_scan/rsa_scan.dart';

abstract class GrantAccessEvent extends Equatable {
  const GrantAccessEvent();
}

class GrantAccess extends GrantAccessEvent {
  final ControlledSpace space;

  final RsaIdDocument scannedIdDocument;

  GrantAccess(this.space, this.scannedIdDocument);

  @override
  List<Object> get props => [space, scannedIdDocument];
}

class GrantVisitorAccess extends GrantAccessEvent {
  final ControlledSpace space;

  final String code;

  final RsaIdDocument scannedIdDocument;

  GrantVisitorAccess(this.space, this.code, this.scannedIdDocument);

  @override
  List<Object> get props => [space, code, scannedIdDocument];
}
