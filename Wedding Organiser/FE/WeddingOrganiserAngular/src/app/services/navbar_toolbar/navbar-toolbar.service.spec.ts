import { TestBed } from '@angular/core/testing';

import { NavbarToolbarService } from './navbar-toolbar.service';

describe('NavbarToolbarService', () => {
  let service: NavbarToolbarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NavbarToolbarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
